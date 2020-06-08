export const state = () => ({
  user: null,
  token: null,
  stayLoggedIn: false,
})

export const mutations = {
  login(state, user) {
    state.user = user
  },
  logout(state) {
    state.user = null
    state.token = null
  },
  token(state, token) {
    state.token = token
  },
  stayLoggedIn(state, val) {
    state.stayLoggedIn = val
  },
}

const baseUrl = '/api/v1/users'

export const actions = {
  init({ commit, dispatch }) {
    let token = localStorage.getItem('user')
    if (!token) {
      token = sessionStorage.getItem('user')
    }
    if (token) {
      // TODO properly validate token
      commit('token', token)
      dispatch('fetchUser')
    }
  },
  async login({ commit, dispatch, state }, { username, password }) {
    await this.$axios
      .post(baseUrl + '/login', null, {
        params: {
          username,
          password,
        },
      })
      .then((res) => {
        if (res.status === 200) {
          commit('token', res.data)
          dispatch('fetchUser')

          if (state.stayLoggedIn) {
            localStorage.setItem('user', res.data)
            sessionStorage.removeItem('user')
          } else {
            sessionStorage.setItem('user', res.data)
            localStorage.removeItem('user')
          }
        }
      })
  },
  logout({ commit }) {
    commit('logout')
    localStorage.removeItem('user')
    sessionStorage.removeItem('user')
  },
  async fetchUser({ commit, state }) {
    await this.$axios
      .get(baseUrl + '/current', {
        headers: {
          Authorization: 'Bearer ' + state.token,
        },
      })
      .then((res) => {
        if (res.status === 200) {
          commit('login', res.data)
        }
      })
  },
}
