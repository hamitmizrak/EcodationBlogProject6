import React, { Component } from 'react'
import RegisterService from '../../services/RegisterService';

export default class RegisterView extends Component {

    constructor(props){
        super(props);
        //state 
        this.state={
            //this ==> php: props.history.push()
            //this ==> pmpi props.match.params.id
            id:this.props.match.params.id,
            registerDto:{

            }
        }
        //bind
    }

    //cdm 
    //1-) constructor
    //2-) render 
    //3-) CDM
    componentDidMount() { 
        RegisterService.apiRegisterFind(this.state.id).then(
            response=>this.setState({
                registerDto:response.data
            }) // end response
        ); //end RegisterService
     }// end componentDidMount

    //function

    render() {
        return (
            <>
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">{this.state.registerDto.id}</h4>
                    <p class="card-text">{this.state.registerDto.username}</p>
                    <p class="card-text">{this.state.registerDto.surname}</p>
                    <p class="card-text">{this.state.registerDto.email}</p>
                    <p class="card-text">{this.state.registerDto.passwd}</p>
                    <p class="card-text">{this.state.registerDto.createdDate}</p>
                    <p class="card-text">{this.state.registerDto.telephoneNumber}</p>
                </div>
            </div>
            </>
        ) //end return
    } // end render
} //end class RegisterList