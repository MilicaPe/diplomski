import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmotionResultComponent } from './emotion-result.component';

describe('EmotionResultComponent', () => {
  let component: EmotionResultComponent;
  let fixture: ComponentFixture<EmotionResultComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmotionResultComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmotionResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
