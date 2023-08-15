import { Injectable } from '@angular/core';
import { ApiService } from '../api.service';
import { loan } from 'src/app/models/loan';

@Injectable({
  providedIn: 'root'
})
export class LoanService {

  constructor(private apiService: ApiService) {}

  applyLoan(data: loan) {
    return this.apiService.postRequest('/api/v1/loan/apply', data);
  }

  payLoan(data: any) {
    return this.apiService.postRequest('/api/v1/loan/pay', data);
  }
}
