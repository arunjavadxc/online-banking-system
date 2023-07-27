import { Injectable } from '@angular/core';
import { ApiService } from '../api.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private apiService: ApiService) { }

  getUserByUserID(userID: string) {
    return this.apiService.getRequest('user/' + userID);
  }

  saveUser(data: any) {
    return this.apiService.postRequest('user/save', data);
  }

}
