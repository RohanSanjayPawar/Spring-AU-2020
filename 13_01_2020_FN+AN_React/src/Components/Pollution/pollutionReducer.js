const initialState = {
    pollution: [],
    filter: [],
    copy: [],
    error: null
};

const FETCH_POLLUTION_SUCCESS = 'FETCH_POLLUTION_SUCCESS';
const FETCH_POLLUTION_FAILURE = 'FETCH_POLLUTION_FAILURE';
const SET_DATA = 'SET_DATA';

export function reducer(state=initialState, action) {
    switch(action.type) {
        case FETCH_POLLUTION_SUCCESS:
            var saved = localStorage.getItem('saved')==='true'?JSON.parse(localStorage.getItem('data')):action.payload.pollution;
            return {
                pollution: saved,
                filter: action.payload.pollution,
                copy: action.payload.pollution,
                error: null
            };
        case FETCH_POLLUTION_FAILURE:
            return {
                error: action.payload.error,
                pollution: [],
                filter: [],
                copy: []
            };

        case SET_DATA:
            var regEx = action.payload.filter;
            var copy = state.copy;
            var filter = state.copy;
            var city = filter.filter((item) => regEx.test(item.city));
            localStorage.setItem('saved', 'true');
            localStorage.setItem('data', JSON.stringify(city));
            return {
                ...initialState,
                error: null,
                pollution: city,
                filter: filter,
                copy: copy
            }
        default:
            return state;
    }
}