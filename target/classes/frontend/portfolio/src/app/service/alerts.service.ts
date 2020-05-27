import { Injectable } from '@angular/core';
import {BehaviorSubject } from 'rxjs';
import { AlertMessage } from '../domain/alert-message';

@Injectable()
export class AlertsService {

  public alertStatus: BehaviorSubject<AlertMessage> = new BehaviorSubject<AlertMessage>(undefined);
  public getAlerts = this.alertStatus.asObservable();

  public sendAlert(alertObj : AlertMessage){
    this.alertStatus.next(alertObj);
  }

  public alertSuccess(msg: string){
    this.sendAlert(new AlertMessage("¡Correct! ", msg, 'success'));
  }

  public alertInfo(msg: string){
    this.sendAlert(new AlertMessage("¡Info! ", msg, 'info'));
  }

  public alertWarning(msg: string){
    this.sendAlert(new AlertMessage("¡Warning! ", msg, 'warning'));
  }

  public alertError(msg: string){
    this.sendAlert(new AlertMessage("¡Error! ", msg, 'danger'));
  }

  public alertError500(error : any){
    this.sendAlert(new AlertMessage("¡Error! ", error.error.message, 'danger'));
  }

}
