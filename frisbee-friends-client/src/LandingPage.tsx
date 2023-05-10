import React from 'react';
import { useDispatch } from 'react-redux';
import { userLoggedIn } from './features/user/userSlice';

const LandingPage: React.FC = () => {
  const dispatch = useDispatch();

  const handleLogin = () => {
    // Dispatch an action to indicate user login
    dispatch(userLoggedIn());
  };

  return (
    <div>
      <header>
        <h1>My Ultimate Frisbee App</h1>
        {/* Add your navigation links */}
      </header>
      <section>
        <h2>Welcome to My Ultimate Frisbee App!</h2>
        <p>Find your perfect Ultimate Frisbee match!</p>
        <button onClick={handleLogin}>Log In</button>
        {/* Add other components and content as needed */}
      </section>
      <footer>
        {/* Add your footer content */}
      </footer>
    </div>
  );
};

export default LandingPage;
