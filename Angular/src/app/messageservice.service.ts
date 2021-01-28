import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import { CurrentWeather } from './currentweather';
import { CurrentWeathers } from './city/current';

@Injectable({
  providedIn: 'root'
})
export class MessageserviceService {

  constructor() { }

  private subject = new Subject<any>();

  sendMessage(message: any) {
      this.subject.next({ message });
  }

  clearMessages() {
      this.subject.next();
  }

  getMessage(): Observable<any> {
      return this.subject.asObservable();
  }
}
