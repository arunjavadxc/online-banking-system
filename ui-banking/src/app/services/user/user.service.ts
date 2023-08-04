import { Injectable } from '@angular/core';
import { ApiService } from '../api.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private apiService: ApiService) { }

  getLoggedInUserDtls() {
    return this.apiService.getUserRequest('/api/v1/user/dtls');
  }

  getUserByUserID(userID: string) {
    return this.apiService.getRequest('/user/api/v1/user/' + userID);
  }

  saveUser(data: any) {
    return this.apiService.postRequest('user/save', data);
  }

  getCurrentBalance(accountNumber: string) {
    return this.apiService.getRequest('/user/api/v1/user/balance/' + accountNumber);
  }

}
