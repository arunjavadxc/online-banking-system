import { Injectable } from '@angular/core';
import { ApiService } from '../api.service';
import { Mail } from 'src/app/models/Mail';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private apiService: ApiService) { }

  sendDebitNotification(mail: Mail) {
    return this.apiService.postRequest('/notification/api/v1/producer', mail);
  }


  sendCreditNotification() {

  }

}
