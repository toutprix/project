import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { After2 } from './after2.component';

describe('After2', () => {
  let component: After2;
  let fixture: ComponentFixture<After2>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ After2 ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(After2);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
