import {Component, OnInit} from '@angular/core';
import {Portfolio} from "../../domain/portfolio";
import {Router} from '@angular/router';
import {AlertsService} from '../../service/alerts.service';
import {PortfolioService} from '../../service/portfolio.service';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  public portfolio: Portfolio = new Portfolio(null, null, null, null, null);

  constructor(public portfolioService: PortfolioService, public alertsService: AlertsService, public router: Router) {
  }

  public search() {
    this.portfolioService.searchFunction(this.portfolio).subscribe((portfolio: Portfolio) => {
      this.exist(portfolio);
    }, (error) => {
      this.alertsService.alertWarning("This username does not exist.");
    });

  }

  public exist(portfolio: Portfolio) {
    this.router.navigate(['/portfolio'], {state: {portfolioData: portfolio}});
  }

  ngOnInit(): void {
  }

}
