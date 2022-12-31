import { createSlice, PayloadAction } from '@reduxjs/toolkit';
import { RootState } from '../store';

export interface AuthState {
    jwt: string | null;
}

const initialState: AuthState = {
    jwt: null
}

const authSlice = createSlice({
    name: 'jwt',
    initialState, 
    reducers: {
        addJWT(state, action: PayloadAction<string>) {
            state.jwt = action.payload;
        },
        removeJWT(state) {
            state.jwt = null;
        }
    }
})

export const { addJWT, removeJWT } = authSlice.actions;

export const selectJWT = (state: RootState) => state.auth.jwt;

export default authSlice.reducer;