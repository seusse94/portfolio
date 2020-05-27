import {Injectable} from '@angular/core';
import { Observable } from 'rxjs/Rx';
import {RestService} from '../service/rest.service';
import {Portfolio} from '../domain/portfolio';



@Injectable({
  providedIn: 'root'
})
export class PortfolioService {
  portfolio : Portfolio;
  constructor(public restService : RestService) {}

  public transformation(ref : any) : Portfolio{
    return new Portfolio(ref.portfolioDto.twitterUserName, ref.portfolioDto.title,ref.portfolioDto.description, ref.portfolioDto.imageUrl, ref.tweets);
  }

  searchFunction(portfolio : Portfolio) : Observable<Portfolio>{
    this.portfolio = portfolio;
    return this.restService.get("/user/"+portfolio.name+"/profile", this.transformation);
  }

}
