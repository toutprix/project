import { Component, OnInit, Injectable } from '@angular/core';

import { TokenStorageService } from '../auth/token-storage.service';
import { UserService } from '../services/user.service';
import { CaseInfo } from '../auth/case-info';

//import { NgForm} from '@angular/forms';

import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})

@Component({
  selector: 'addcase',
  templateUrl: './addcase.component.html',
  styleUrls: ['./addcase.component.css']
})
export class AddcaseComponent implements OnInit {
  form: any = {};
  private caseInfo : CaseInfo;
  //userService : UserService;


  constructor( private userService: UserService, private http: HttpClient,private tokenStorage: TokenStorageService) { }


  ngOnInit() {
  
  }

 onSubmit() {
    console.log(this.form);

	this.caseInfo = new CaseInfo(
    this.form.text,
    this.form.calendar,
    this.tokenStorage.getUsername());
     
    this.userService.addCase(this.caseInfo);
    //this.http.post<string>("http://localhost:8080/api/test/addcase",this.caseInfo, httpOptions).subscribe();


  }
}
