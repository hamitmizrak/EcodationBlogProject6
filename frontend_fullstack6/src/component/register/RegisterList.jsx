import React, { Component } from 'react'
import RegisterService from '../../services/RegisterService';

//classlar state bir yapıdadır. state yazarız: statefull
//classlar this çok sever
export default class RegisterList extends Component {

    // constructor
    constructor(props) {
        super(props);
        this.state = {
            registerList: [],
        }
        //bind
        this.addRegister = this.addRegister.bind(this);
        this.updateRegister = this.updateRegister.bind(this);
        this.viewRegister = this.viewRegister.bind(this);
        this.deleteRegister = this.deleteRegister.bind(this);
    } //end constructor



     //cdm 
    //1-) constructor
    //2-) render 
    //3-) CDM
    //cdm:api servise erişim sağlamak
    componentDidMount() {
        RegisterService.apiRegisterList().then(
            (response) => {
                this.setState(
                    {
                        registerList: response.data
                    }
                )
            }
        )
    }
     //function

    //EKLEME SAYFASI REDIRECT
    addRegister() {
        //this => php
        this.props.history.push("/register_add/");
    }

    //GÜNCELLEME SAYFASI REDIRECT
    updateRegister(id) {
        //this => php
        this.props.history.push("/register_add/" + id);
    }

    //VİEW SAYFASI REDIRECT
    viewRegister(id) {
        //this => php
        this.props.history.push(`/register_view/${id}`);
    }

    //DELETE  REDIRECT
    deleteRegister(id) {
        //this => php
        RegisterService.apiRegisterDelete(id).then(
            response => {
                this.setState({
                    registerList: this.state.registerList.filter(
                        registerList => registerList.id != id
                    )
                }) //end setState
            } //end response
        )// end RegisterService
    } //end deleteRegister

    //render
    render() {
        return (
            <>
                <h1 className="text-center display-4 text-primary">Register List</h1>
                <button className="btn btn-primary" onClick={this.addRegister}>EKLE</button>
                <table className="table table-hover table-striped">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>USERNAME</th>
                            <th>SURNAME</th>
                            <th>EMAİL</th>
                            <th>PASSWORD</th>
                            <th>TELEPHONE</th>
                            <th>DATE</th>
                            <th>Update</th>
                            <th>View</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.registerList.map(temp =>
                                <tr key={temp.id}>
                                    <td>{temp.id}</td>
                                    <td>{temp.username}</td>
                                    <td>{temp.surname}</td>
                                    <td>{temp.passwd}</td>
                                    <td>{temp.email}</td>
                                    <td>{temp.telephoneNumber}</td>
                                    <td>{temp.createdDate}</td>
                                    <td><i style={{ cursor: "pointer" }} className="fa-solid fa-pen-to-square text-primary" onClick={() => this.updateRegister(temp.id)}></i></td>
                                    <td><i style={{ cursor: "pointer" }} className="fa-solid fa-tower-observation text-warning" onClick={() => this.viewRegister(temp.id)}></i></td>
                                    <td><i style={{ cursor: "pointer" }} className="fa-solid fa-trash text-danger" onClick={() => {
                                        if (window.confirm("Silmek istiyor musunuz ?")) {
                                            this.deleteRegister(temp.id)
                                        }
                                    }}></i></td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </>
        ) //end return
    } // end render
} //end class RegisterList

