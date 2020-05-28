import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-portfolio',
  templateUrl: './portfolio.component.html',
  styleUrls: ['./portfolio.component.css']
})

export class PortfolioComponent implements OnInit {

  portfolio: any;
  hasImage: boolean;

  constructor(public router: Router) {
    this.portfolio = this.router.getCurrentNavigation().extras.state;
    if (this.portfolio != undefined) {
      if (this.portfolio.portfolioData.imageUrl !== "" && this.portfolio.portfolioData.imageUrl !== " " && this.portfolio.portfolioData.imageUrl !== null) {
        this.hasImage = true;
      }
    }


  }

  ngOnInit(): void {

  }
  public back(){
    this.router.navigate(['']);

  }

}
