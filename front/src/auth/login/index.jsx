import LOGO from '../../assets/logo.png'
import './index.css'
import { Image1 } from '../../utils/images'
import {useState} from 'react'

export const Form = () => {

    const [isLogin, setIsLogin] = useState(true);

    const handleOnClick = (e)=>{
        e.preventDefault();
        console.log("clicked")
        setIsLogin(!isLogin)
    }

    return (
        <div className={`my-container containter-fluid h-100 card rounded ${isLogin?'login-state':'register-state'}`}>
            <div className='row h-100'>
                <div className={`col-md-6 p-0 img-container ${isLogin?'':'animate'}`}>
                    <div className='d-flex justify-content-center align-items-center h-100'>
                        <img className='login-img' src={Image1} alt='Logo' />
                    </div>
                </div>
                <div className={`col-md-6 login-card-main ${isLogin?'':'animate'}`}>
                    <div className='d-flex justify-content-center align-items-center h-100'>
                        <div className='login-card card mx-2'>
                            <div className='card-body'>
                                <img className='logo-img' src={LOGO} alt='Logo' width="190px" />
                                <h3 className='card-title'>{isLogin?'Sign in with account':'Sign up with account'}</h3>

                                <form>
                                    {!isLogin && (<div className={`form-group m-2`}>
                                        <input type='text' className='form-control' placeholder='Full Name' />
                                    </div>
                                    )}
                                    <div className={`form-group ${isLogin?'m-4':'m-2'}`}>
                                        {isLogin && (<label>Email Address</label>)}
                                        <input type='email' className='form-control' placeholder='Email' />
                                    </div>
                                    {!isLogin && (<div className='form-group m-2'>
                                        <input type='number' className='form-control' placeholder='Phone' />
                                    </div>
                                    )}
                                    <div className={`form-group ${isLogin?'m-4':'m-2'}`}>
                                    {isLogin && (<label>Pasword</label>)}
                                        <input type='password' className='form-control' placeholder='Password' />
                                    </div>
                                    {!isLogin && (<div className='form-group m-2'>
                                        <input type='password' className='form-control' placeholder='Confirm Password' />
                                    </div>
                                    )}
                                    <button type='submit' className='login-btn btn btn-primary'>{isLogin?'Login':'Register'}</button>
                                    <div className='form-group'>
                                    {isLogin && (<button className='btn btn-link'>Forgot Password</button>)}
                                    </div>
                                    <div className='form-group'>
                                    {isLogin?'Not a User?':'Already a User'}<button className='btn btn-link' onClick={handleOnClick}>{isLogin?'Register':'Login'}</button>
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
            </div>
        </div>
    )
}

