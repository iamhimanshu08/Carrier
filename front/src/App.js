
import {Auth} from './auth/index'

import './App.css';
import Login from './login/Login.jsx';
import Index from './register/Index';

function App() {
  return (
    <div className="App">

      <Auth/>

      <Login/>
      {/* <Index/> */}
      
    </div>
  );
}

export default App;
