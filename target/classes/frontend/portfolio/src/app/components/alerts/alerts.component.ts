import {Component, OnInit} from '@angular/core';
import {NgbAlertConfig} from '@ng-bootstrap/ng-bootstrap';
import {AlertsService} from '../../service/alerts.service';
import {AlertMessage} from '../../domain/alert-message';

@Component({
  selector: 'app-alerts',
  templateUrl: 'alerts.component.html',
  styleUrls: ['alerts.component.css'],
  providers: [NgbAlertConfig]
})
export class AlertsComponent implements OnInit {

  public seconds: number;
  public alerts: Array<AlertMessage> = [];

  constructor(public alertConfig: NgbAlertConfig, public alertsService: AlertsService) {
    alertConfig.dismissible = false;
    this.seconds = 10;
  }

  ngOnInit(){
    this.alertsService.getAlerts.subscribe((alert : AlertMessage) => {
      if(alert != undefined) {
        this.alerts.push(alert);
        setTimeout(()=>this.closeAlert(alert), this.seconds * 1000)
      }
    });
  }

  closeAlert(alerta: AlertMessage) {
    alerta.display = "hide";
    setTimeout(()=>{
      const index: number = this.alerts.indexOf(alerta);
      this.alerts.splice(index, 1);
    }, 500)
  }

}
