import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SearchComponent} from "./components/search/search.component";
import {PortfolioComponent} from "./components/portfolio/portfolio.component";


const routes: Routes = [
  {path: '', component: SearchComponent},
  {path: 'portfolio', component: PortfolioComponent}

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})


export class AppRoutingModule { }
