export const state = () => ({
  announcements: [],
})

export const mutations = {
  save(state, announcements) {
    state.announcements = announcements
  },
  add(state, announcement) {
    state.announcements.push(announcement)
  },
}

const baseUrl = '/api/v1/announcement'

export const actions = {
  async load({ commit }) {
    await this.$axios.get(baseUrl + '/').then((res) => {
      if (res.status === 200) {
        commit('save', res.data)
      }
    })
  },
  async loadBySlug({ commit }, slug) {
    await this.$axios.get(baseUrl + '/' + slug).then((res) => {
      if (res.status === 200) {
        commit('add', res.data)
      }
    })
  },
}
