export class UrlService {
  private static readonly MONOLITH_URL = 'http://localhost:8080/BMS/';
  constructor() { }
  public getUrl(): string {
    return UrlService.MONOLITH_URL;
  }
}
