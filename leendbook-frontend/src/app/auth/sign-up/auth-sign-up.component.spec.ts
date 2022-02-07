import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthSignUpComponent } from './auth-sign-up.component';

describe('AuthComponent', () => {
  let component: AuthSignUpComponent;
  let fixture: ComponentFixture<AuthSignUpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AuthSignUpComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthSignUpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
