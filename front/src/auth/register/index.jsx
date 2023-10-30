import LOGO from '../../assets/logo.png'
import './index.css'
import { Image1 } from '../../utils/images'

export const Form = () => {
    return (
        <div className='my-container containter-fluid h-100 card rounded'>
            <div className='row h-100'>
                <div className='col-md-6 login-card-main'>
                    <div className='d-flex justify-content-center align-items-center h-100'>
                        <div className='login-card card mx-2'>
                            <div className='card-body'>
                                <img className='logo-img' src={LOGO} alt='Logo' width="190px" />
                                <h3 className='card-title'>Register with us</h3>

                                <form>
                                <div className='form-group m-2'>
                                        {/* <label>Full Name</label> */}
                                        <input type='text' className='form-control' placeholder='Full Name' />
                                    </div>
                                    <div className='form-group m-2'>
                                        {/* <label>Email Address</label> */}
                                        <input type='email' className='form-control' placeholder='Email' />
                                    </div>
                                    <div className='form-group m-2'>
                                        {/* <label>Phone Number</label> */}
                                        <input type='number' className='form-control' placeholder='Phone' />
                                    </div>
                                    <div className='form-group m-2'>
                                        {/* <label>Create Pasword</label> */}
                                        <input type='password' className='form-control' placeholder='Password' />
                                    </div>
                                    <div className='form-group m-2'>
                                        {/* <label>Confirm Pasword</label> */}
                                        <input type='password' className='form-control' placeholder='Confirm Password' />
                                    </div>
                                    <button type='submit' className='login-btn btn btn-primary'>Register</button>
                                    
                                    <div className='form-group'>
                                        Already a User?<button className='btn btn-link'>Login</button>
                                    </div>
                                </form>
                                <div className="divider d-flex align-items-center my-4">
                                    <p className="text-center fw-bold mx-3 mb-0">OR</p>
                                </div>
                                <button className='btn btn-outline-secondary'>Sign in with Google</button>

                            </div>
                        </div>
                    </div>
                </div>
                <div className='col-md-6 p-0'>
                    <div className='d-flex justify-content-center align-items-center h-100'>
                        <img className='login-img' src={Image1} alt='Logo' />
                    </div>
                </div>
            </div>
            
        </div>

    )
}


        // <div>
        //     <h1>Register</h1><br/>
        //     <input type='text' placeholder='Enter fullname'/><br/>
        //     <input type='email' placeholder='Enter email'/><br/>
        //     <input type='number' placeholder='Enter phonenumber'/><br/>
        //     <input type='password' placeholder='Enter password'/><br/>
        //     <input type='password' placeholder='Confirm password'/><br/>

        //     <button>Register</button>

        // </div>