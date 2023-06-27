import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmotionHistoryComponent } from './emotion-history.component';

describe('EmotionHistoryComponent', () => {
  let component: EmotionHistoryComponent;
  let fixture: ComponentFixture<EmotionHistoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmotionHistoryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmotionHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
