import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JwtResponse } from '../auth/jwt-response';
import { CaseInfo } from '../auth/case-info';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})

export class UserService {

  private userAddcase = 'http://localhost:8080/api/test/addcase';
  private todayUrl = 'http://localhost:8080/api/test/today';
  private afterUrl = 'http://localhost:8080/api/test/after';
  private after2Url = 'http://localhost:8080/api/test/after2';
  private after3Url = 'http://localhost:8080/api/test/after3';
  private monthUrl = 'http://localhost:8080/api/test/month';

  constructor(private http: HttpClient) { }
  
  addCase(caseInfo: CaseInfo) {
   	return this.http.post<CaseInfo>(this.userAddcase, caseInfo, httpOptions).subscribe();
  }
  
  getToday() {
    return this.http.get(this.todayUrl);
  }
  
  getAfter() {
    return this.http.get(this.afterUrl);
  }
  
  getAfter2() {
    return this.http.get(this.after2Url);
  }
  
  getAfter3() {
    return this.http.get(this.after3Url);
  }
  
  getMonth() {
    return this.http.get(this.monthUrl);
  }

}
