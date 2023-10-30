import React from 'react'

const Index = () => {
  return (
    <div>
        <h1><b>Registration</b></h1><br/>
        <label>Full Name</label>
        <input type='text' placeholder = 'Enter your name'/><br/>
        <label>Email</label>
        <input type = 'email' placeholder='Enter your Email'/><br/>
        <label>Mobile no</label>
        <input type='number' placeholder='Enter your Mobile no.'/><br/>
        <label>Password</label>
        <input type='password' placeholder='Enter your password'/><br/>
        <label>CPassword</label>
        <input type='password' placeholder='Confirm your password'/><br/>
        <button className='btn btn-success'>Submit</button>
      
    </div>
  )
}

export default Index
