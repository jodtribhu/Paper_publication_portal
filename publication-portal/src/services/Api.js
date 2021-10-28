import axios from 'axios';

export default() =>{
    return axios.create({
        baseURL:'http://localhost:8084/Publication_Portal_Server/'
    });
}