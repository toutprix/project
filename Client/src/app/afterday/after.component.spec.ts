import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { After } from './after.component';

describe('After', () => {
  let component: After;
  let fixture: ComponentFixture<After>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ After ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(After);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
