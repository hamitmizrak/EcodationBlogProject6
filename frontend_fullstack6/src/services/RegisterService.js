import axios from "axios";

const REGISTER_URL = "/register";
class RegisterService {

    // CREATE
    apiRegisterCreate(registerDto) {
        return axios.post(REGISTER_URL + "/create", registerDto);
    }

    //LIST
    apiRegisterList() {
        return axios.get(REGISTER_URL + "/list")
    }

    //FIND
    apiRegisterFind(id) {
        return axios.get(REGISTER_URL + "/" + id)
    }


    //PUT
    apiRegisterUpdate(id,registerDto){
        return axios.put(REGISTER_URL + "/" + id,registerDto)
    }

    //DELETE
    apiRegisterDelete(id){
        return axios.delete(REGISTER_URL + "/" + id);
    }

} //end class RegisterService 

export default new RegisterService();

