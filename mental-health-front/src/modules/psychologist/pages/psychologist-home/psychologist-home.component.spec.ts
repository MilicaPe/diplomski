import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PsychologistHomeComponent } from './psychologist-home.component';

describe('PsychologistHomeComponent', () => {
  let component: PsychologistHomeComponent;
  let fixture: ComponentFixture<PsychologistHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PsychologistHomeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PsychologistHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
