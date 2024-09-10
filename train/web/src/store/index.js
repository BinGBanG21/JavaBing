import {createStore} from 'vuex'

export default createStore({
    state: {
        member: window.SessionStorage.get(MEMBER) || {}
    },
    getters: {},
    mutations: {
        setMember(state, _member) {
            state.member = _member;
            window.SessionStorage.set(MEMBER, _member);
        }
    },
    actions: {},
    modules: {}
})
