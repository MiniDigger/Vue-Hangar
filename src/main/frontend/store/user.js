export const state = () => ({
  user: null,
  token: null,
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
}

const baseUrl = '/api/v1/users'

export const actions = {
  async login({ commit, dispatch }, { username, password }) {
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
        }
      })
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
