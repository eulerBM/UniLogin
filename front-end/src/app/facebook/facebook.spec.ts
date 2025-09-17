import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Facebook } from './facebook';

describe('Facebook', () => {
  let component: Facebook;
  let fixture: ComponentFixture<Facebook>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Facebook]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Facebook);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
