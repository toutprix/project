import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { All } from './adll.component';

describe('HomeComponent', () => {
  let component: All;
  let fixture: ComponentFixture<All>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ All ]
    })
    .compileComponents();
  }));



  beforeEach(() => {
    fixture = TestBed.createComponent(All);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
