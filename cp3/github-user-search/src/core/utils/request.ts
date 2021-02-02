import axios, { AxiosResponse } from 'axios';

const getUserInfoFromGithub = (
  userName: string,
): Promise<AxiosResponse<any>> => {
  return axios.get(`https://api.github.com/users/${userName}`);
};

export default getUserInfoFromGithub;
