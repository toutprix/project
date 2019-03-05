import { Component, OnInit } from '@angular/core';

import { TokenStorageService } from '../auth/token-storage.service';
import { UserService } from '../services/user.service';
import { CaseInfo } from '../auth/case-info';


@Component({
  selector: 'app-today',
  templateUrl: './after.component.html',
  styleUrls: ['./after.component.css']
})
export class After implements OnInit {
  info: any;
  List: Object;
  private caseInfo : CaseInfo;
  public test : any;
  
  response: string;

  //userService : UserService;
  //cases = this.userService.getToday();
  
  //cases = this.service.getToday();
  constructor( private token: TokenStorageService, private service : UserService ){ 
  }



  ngOnInit() {
  
  //this.service.getToday().subscribe(
  //              response => this.response = response,
  //              error => console.log(error));
  
  //this.service.getAfter().then(result => this.data = result);
  this.service.getAfter().subscribe(data => this.List = data);
  //console.log(this.test);
  //this.List = JSON.parse(this.service.getToday().toString());
  //console.log(JSON.stringify(this.List));
  //console.log(this.test);
  //this.service.getToday().subscribe(data => {this.text = data});
  //    data => {
  //      this.board = data;
      // this.text = make;
       // this.date = date
  //    });
    //this.info = {
    //  token: this.token.getToken(),
    //  username: this.token.getUsername(),
    //  authorities: this.token.getAuthorities()
    //};
  }


  logout() {
    this.token.signOut();
    window.location.reload();
  }
}

 //template: `<div *ngFor="let case of cases | async">
  //<b>beeeeeeeeeeee</b>
  //    <p><b>{{b}} {{case.date}}</b></p>
  //  </div>`,