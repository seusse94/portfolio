export class AlertMessage {
  public title: string;
  public message: string;
  public type: string;
  public display: string;

  constructor(title: string, message: string, type: string){
    this.title = title;
    this.message = message;
    this.type = type;
    this.display = 'show';
  }

}
