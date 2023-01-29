import React from 'react'

export default function Footer(props) {
  return (
    <>
  

  <footer className="bg-dark text-center text-lg-start text-white mt-2 fixed-bottom44">
  <div className="container p-4 pb-0">
    <form action="">
      <div className="row">
        <div className="col-auto mb-4 mb-md-0">
          <p className="pt-2">
            <strong>Sign up for our newsletter</strong>
          </p>
        </div>
    
        <div className="col-md-5 col-12 mb-4 mb-md-0">
          <div className="form-outline mb-4">
            <input type="email" id="form5Example25" className="form-control" />
            <label className="form-label" htmlFor="form5Example25">Email address</label>
          </div>
        </div>
        <div className="col-auto mb-4 mb-md-0">
          <button type="submit" className="btn btn-primary mb-4">
            Subscribe
          </button>
        </div>
      </div>
    </form>
  </div>

  <div className="text-center p-3" style={{backgroundColor: "rgba(0, 0, 0, 0.2)"}}>
    © 2020 Copyright: {props.allright}
    <a className="text-dark" href="https://"></a>
  </div>
</footer>
    
    </>
  )
}
