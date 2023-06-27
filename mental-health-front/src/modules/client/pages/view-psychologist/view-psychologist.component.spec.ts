import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPsychologistComponent } from './view-psychologist.component';

describe('ViewPsychologistComponent', () => {
  let component: ViewPsychologistComponent;
  let fixture: ComponentFixture<ViewPsychologistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewPsychologistComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewPsychologistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
