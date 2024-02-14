import axios from 'axios';

export default axios.create({
    baseURL:'//localhost:8080/api/v1/',
    headers:{"cross-origin":"*"},
});