import React from 'react'


function Login() {
  return (
    <div className='form-group'>
      <h1 ><b>Login</b></h1>
      <br/>
      <label>Username</label>
      <input type='text' placeholder = 'Enter your Username'/><br/>
      <label>Password</label>
      <input type = 'password' placeholder='Enter your Password'/><br/>
    <button className='btn btn-success'>Login</button>
    </div>
  )
}

export default Login;
