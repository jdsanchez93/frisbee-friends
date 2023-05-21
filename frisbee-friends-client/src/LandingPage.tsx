import React from 'react';
import { useDispatch } from 'react-redux';
import { userLoggedIn } from './features/user/userSlice';

const LandingPage: React.FC = () => {
  const dispatch = useDispatch();

  const handleLogin = () => {
    // Dispatch an action to indicate user login
    dispatch(userLoggedIn());
  };

  const callApi = () => {
    fetch('/api/demo/all')
      .then(x => x.json())
      .then(x => console.log(x))
      .catch(e => console.error('api error', e))
  }

  const logout = () => {
    fetch('/logout', {
      method: 'POST'
    })
      .then(x => x.json())
      .then(x => console.log(x))
      .catch(e => console.error('api error', e))
  }

  const loginGithub = () => {
    fetch('/oauth2/authorization/github', {
      method: 'GET',
      // TODO figure out cors
      mode: 'no-cors',
      
    })
      .then(x => console.log(x))
      .catch(e => console.error('api error', e))
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
        <button onClick={callApi}>call api</button>
        <button onClick={logout}>logout</button>

        <button onClick={loginGithub}>LOGIN</button>
        {/* Add other components and content as needed */}
      </section>
      <footer>
        {/* Add your footer content */}
      </footer>
    </div>
  );
};

export default LandingPage;
