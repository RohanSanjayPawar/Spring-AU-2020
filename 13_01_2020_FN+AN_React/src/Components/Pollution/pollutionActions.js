export const FETCH_POLLUTION_SUCCESS = 'FETCH_POLLUTION_SUCCESS';
export const FETCH_POLLUTION_FAILURE = 'FETCH_POLLUTION_FAILURE';
export const SET_DATA = 'SET_DATA';

export function fetchPollution() {
    return dispatch => {
        return fetch("data.json")
        .then(res => res.json())
        .then(data => {
            dispatch(fetchPollutionSuccess(data));
            return data.pollution
        })
        .catch(error => dispatch(fetchPollutionFailure(error)));
    };
}

const fetchPollutionSuccess = pollution => ({
    type: FETCH_POLLUTION_SUCCESS,
    payload: { pollution }
});

const fetchPollutionFailure = error => ({
    type: FETCH_POLLUTION_FAILURE,
    payload: { error }
});

export const setData = filter => ({
    type: SET_DATA,
    payload: { filter }
});