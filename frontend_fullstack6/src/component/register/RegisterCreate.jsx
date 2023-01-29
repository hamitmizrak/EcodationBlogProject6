import React, { Component } from 'react'
import RegisterService from '../../services/RegisterService';

export default class RegisterCreate extends Component {
    constructor(props) {
        super(props);
        this.state = {
            id: this.props.match.params.id,
            username: "",
            surname: "",
            email: "",
            passwd: "",
            telephoneNumber: ""
        }
        //bind
        this.headerDynamicsCreateOrUpdate = this.headerDynamicsCreateOrUpdate.bind(this);
        this.onChangeUserName = this.onChangeUserName.bind(this);
        this.onChangeSurname = this.onChangeSurname.bind(this);
        this.onChangeEmail = this.onChangeEmail.bind(this);
        this.onChangePassword = this.onChangePassword.bind(this);
        this.createOrUpdate = this.createOrUpdate.bind(this);
    }

    //cdm
    componentDidMount() {
        if (this.state.id === "register_add") {
            return;
        } else {
            RegisterService.apiRegisterFind(this.state.id).then(
                response => {
                    const registerDto = response.data;
                    console.log(registerDto);
                    this.setState({
                        username: registerDto.username,
                        surname: registerDto.surname,
                        email: registerDto.email,
                        passwd: registerDto.passwd,
                        telephoneNumber: registerDto.telephoneNumber,
                    }) //end setState
                }//end response
            );//end RegisterService
        }//end else
    }//end componentDidMount


    //function
    headerDynamicsCreateOrUpdate() {
        if (this.state.id === "register_add")
            return <h1 className="display-3 text-center mt-3">EKLE</h1>
        else
            return <h1 className="display-3 text-center mt-3">GÜNCELLEME</h1>
    }


    //FORM input
    onChangeUserName(event) {
        this.setState({
            username: event.target.value
        })
    };

    onChangeSurname(event) {
        this.setState({
            surname: event.target.value
        })
    };


    onChangeEmail(event) {
        this.setState({
            email: event.target.value
        })
    };


    onChangePassword(event) {
        this.setState({
            passwd: event.target.value
        })
    };

    onChangeTelephoneNumber(event) {
        this.setState({
            telephoneNumber: event.target.value
        })
    };



    //SUBMIT
    createOrUpdate = (event) => {
        event.preventDefault();
        const registerDto = {
            username: this.state.username,
            surname: this.state.surname,
            email: this.state.email,
            passwd: this.state.passwd,
            telephoneNumber: this.state.telephoneNumber,
        }

        //EKLEME
        if (this.state.id === "register_add") {
            RegisterService.apiRegisterCreate(registerDto).then(
                response => {
                    if (response.status === 200) {
                        this.props.history.push("/register_list");
                    }
                }
            ).catch(error => {
                console.log("CREATE NOT: " + error.response.data)
            }); //then
        } else {
            RegisterService.apiRegisterUpdate(this.state.id, registerDto).then(
                response => {
                    if (response.status === 200) {
                        this.props.history.push("/register_list");
                    }
                }
            ).catch(error => {
                console.log("UPDATE NOT: " + error.response.data)
            }); //then
        }
    }



    render() {
        return (
            <>
                <span className='mt-5' style={{ marginTop: "5%" }}></span>
                {this.headerDynamicsCreateOrUpdate()}
                < div className="container" >
                    <div className="row">
                        <div className="card-body shadow">

                            <div className="form-group mb-3">
                                <label htmlFor="">USERNAME</label>
                                <input type="text"
                                    className="form-control"
                                    name="username" id="username"
                                    placeholder='Kullanıcı adınız'
                                    onChange={this.onChangeUserName}
                                    value={this.state.username}
                                />
                            </div>

                            <div className="form-group mb-3">
                                <label htmlFor="">SURNAME</label>
                                <input type="text"
                                    className="form-control"
                                    name="surname" id="surname"
                                    placeholder='Kullanıcı surname'
                                    onChange={this.onChangeSurname}
                                    value={this.state.surname}
                                />
                            </div>


                            {/* <div className="form-group mb-3">
                                <label htmlFor="">PASSWORD</label>
                                <input type="text"
                                    className="form-control"
                                    name="username" id="username"
                                    placeholder='Kullanıcı şifreniz'
                                    onChange={this.onChangePassword}
                                    value={this.state.passwd}
                                />
                            </div>*/}

                            <div className="form-group mb-3">
                                <label htmlFor="">TELEPHONE</label>
                                <input type="text"
                                    className="form-control"
                                    name="telephoneNumber" id="telephoneNumber"
                                    placeholder='telefon numarası'
                                    onChange={this.onChangeTelephoneNumber}
                                    value={this.state.telephoneNumber}
                                />
                            </div>

                            <div className="form-group mb-3">
                                <label htmlFor="">EMAİL</label>
                                <input type="text"
                                    className="form-control"
                                    name="email" id="email"
                                    placeholder='Kullanıcı email'
                                    onChange={this.onChangeEmail}
                                    value={this.state.email}
                                />
                            </div>


                            <div className="form-group mb-3">
                                <button className="btn btn-primary" onClick={this.createOrUpdate}>Gönder</button>
                            </div>

                        </div>  {/* card-body */}
                    </div>  {/* row */}
                </div>  {/* container */}
            </ >
        ) //end return
    } // end render
} //end class RegisterList

// resuabilty
// update 
// create
// spinner (loading)
