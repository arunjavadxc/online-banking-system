import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { environment } from "src/environments/environment";

const baseURL = environment.apiUrl;

@Injectable({
    providedIn: 'root'
})
export class ApiService {

    constructor(private httpClient: HttpClient) {
        this.prepareJSONHeader();
    }

    headerEntry: any;
    headers!: HttpHeaders;

    getRequest(url: string): Observable<any> {
        return this.httpClient.get(baseURL + url, { headers: this.headers, observe: "response" });
    }

    postRequest(url: string, body?: any, params?: any): Observable<any> {
        return this.httpClient.post<any>(baseURL + url, body, { headers: this.headers, observe: "response", params: params });
    }

    prepareJSONHeader() {
        this.headerEntry = {
            'Content-Type': 'application/json'
        };

        this.headers = new HttpHeaders(this.headerEntry);
    }
}
