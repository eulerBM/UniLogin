import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Google } from './google';

describe('Google', () => {
  let component: Google;
  let fixture: ComponentFixture<Google>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Google]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Google);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
