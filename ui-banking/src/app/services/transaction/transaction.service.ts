import { Injectable } from '@angular/core';
import { ApiService } from '../api.service';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  constructor(private apiService: ApiService) { }

  transferAmount(data: any) {
    return this.apiService.postRequest('/transaction/api/v1/transactions', data);
  }

  getAllTransactionFroAccount(accountNumber: string) {
    return this.apiService.getRequest('/transaction/api/v1/transactions/' + accountNumber);
  }

}
