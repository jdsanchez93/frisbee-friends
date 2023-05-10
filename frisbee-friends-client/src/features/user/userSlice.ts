import { createSlice, PayloadAction } from '@reduxjs/toolkit';

interface UserState {
  loggedIn: boolean;
  username: string | null;
  // Add any other user-related state properties
}

const initialState: UserState = {
  loggedIn: false,
  username: null,
};

const userSlice = createSlice({
  name: 'user',
  initialState,
  reducers: {
    userLoggedIn: (state) => {
      state.loggedIn = true;
    },
    userLoggedOut: (state) => {
      state.loggedIn = false;
      state.username = null;
    },
    setUsername: (state, action: PayloadAction<string>) => {
      state.username = action.payload;
    },
    // Add any other user-related reducers
  },
});

export const { userLoggedIn, userLoggedOut, setUsername } = userSlice.actions;

export default userSlice.reducer;