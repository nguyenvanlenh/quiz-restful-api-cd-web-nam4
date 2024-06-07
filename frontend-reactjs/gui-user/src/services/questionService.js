import axios from "axios";
import { URL_PATH } from "../utils/constants";
import { getDataByKeyLS } from "../utils/common";

const token = getDataByKeyLS("auth")?.token

export const questionService = {
    uploadFileQuestion: (file, answerFile) => {
        const url = URL_PATH + "/api/upload"
        const formData = new FormData();
        formData.append('file', file);
        formData.append('answerFile', answerFile);

        const config = {
            headers: {
                Authorization: `Bearer ${token}`,
                'Content-Type': 'multipart/form-data',
            },
        };
        return axios.post(url, formData, config)
            .then(response => {
                return response.data;
            })
            .catch(error => {
                console.log(error.response?.data.message)
                return error.response
            })
    },
}