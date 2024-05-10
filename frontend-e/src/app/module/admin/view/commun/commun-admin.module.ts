import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ToastModule} from 'primeng/toast';
import {ToolbarModule} from 'primeng/toolbar';
import {TableModule} from 'primeng/table';
import {DropdownModule} from 'primeng/dropdown';
import {InputSwitchModule} from 'primeng/inputswitch';
import {InputTextareaModule} from 'primeng/inputtextarea';

import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import {TranslateModule} from '@ngx-translate/core';
import {FileUploadModule} from 'primeng/fileupload';
import {FullCalendarModule} from '@fullcalendar/angular';
import {CardModule} from "primeng/card";

import { KeepNoteCreateAdminComponent } from './keep-note/create/keep-note-create-admin.component';
import { KeepNoteEditAdminComponent } from './keep-note/edit/keep-note-edit-admin.component';
import { KeepNoteViewAdminComponent } from './keep-note/view/keep-note-view-admin.component';
import { KeepNoteListAdminComponent } from './keep-note/list/keep-note-list-admin.component';
import { UtilisateurCreateAdminComponent } from './utilisateur/create/utilisateur-create-admin.component';
import { UtilisateurEditAdminComponent } from './utilisateur/edit/utilisateur-edit-admin.component';
import { UtilisateurViewAdminComponent } from './utilisateur/view/utilisateur-view-admin.component';
import { UtilisateurListAdminComponent } from './utilisateur/list/utilisateur-list-admin.component';
import { TypeContenuCreateAdminComponent } from './type-contenu/create/type-contenu-create-admin.component';
import { TypeContenuEditAdminComponent } from './type-contenu/edit/type-contenu-edit-admin.component';
import { TypeContenuViewAdminComponent } from './type-contenu/view/type-contenu-view-admin.component';
import { TypeContenuListAdminComponent } from './type-contenu/list/type-contenu-list-admin.component';
import { CategoryEmailCreateAdminComponent } from './category-email/create/category-email-create-admin.component';
import { CategoryEmailEditAdminComponent } from './category-email/edit/category-email-edit-admin.component';
import { CategoryEmailViewAdminComponent } from './category-email/view/category-email-view-admin.component';
import { CategoryEmailListAdminComponent } from './category-email/list/category-email-list-admin.component';
import { ContactCreateAdminComponent } from './contact/create/contact-create-admin.component';
import { ContactEditAdminComponent } from './contact/edit/contact-edit-admin.component';
import { ContactViewAdminComponent } from './contact/view/contact-view-admin.component';
import { ContactListAdminComponent } from './contact/list/contact-list-admin.component';
import { EtatEmailCreateAdminComponent } from './etat-email/create/etat-email-create-admin.component';
import { EtatEmailEditAdminComponent } from './etat-email/edit/etat-email-edit-admin.component';
import { EtatEmailViewAdminComponent } from './etat-email/view/etat-email-view-admin.component';
import { EtatEmailListAdminComponent } from './etat-email/list/etat-email-list-admin.component';

import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';
import {PaginatorModule} from 'primeng/paginator';



@NgModule({
  declarations: [

    KeepNoteCreateAdminComponent,
    KeepNoteListAdminComponent,
    KeepNoteViewAdminComponent,
    KeepNoteEditAdminComponent,
    UtilisateurCreateAdminComponent,
    UtilisateurListAdminComponent,
    UtilisateurViewAdminComponent,
    UtilisateurEditAdminComponent,
    TypeContenuCreateAdminComponent,
    TypeContenuListAdminComponent,
    TypeContenuViewAdminComponent,
    TypeContenuEditAdminComponent,
    CategoryEmailCreateAdminComponent,
    CategoryEmailListAdminComponent,
    CategoryEmailViewAdminComponent,
    CategoryEmailEditAdminComponent,
    ContactCreateAdminComponent,
    ContactListAdminComponent,
    ContactViewAdminComponent,
    ContactEditAdminComponent,
    EtatEmailCreateAdminComponent,
    EtatEmailListAdminComponent,
    EtatEmailViewAdminComponent,
    EtatEmailEditAdminComponent,
  ],
  imports: [
    CommonModule,
    ToastModule,
    ToolbarModule,
    TableModule,
    ConfirmDialogModule,
    DialogModule,
    PasswordModule,
    InputTextModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    SplitButtonModule,
    BrowserAnimationsModule,
    DropdownModule,
    TabViewModule,
    InputSwitchModule,
    InputTextareaModule,
    CalendarModule,
    PanelModule,
    MessageModule,
    MessagesModule,
    InputNumberModule,
    BadgeModule,
    MultiSelectModule,
    PaginatorModule,
    TranslateModule,
    FileUploadModule,
    FullCalendarModule,
    CardModule,

  ],
  exports: [
  KeepNoteCreateAdminComponent,
  KeepNoteListAdminComponent,
  KeepNoteViewAdminComponent,
  KeepNoteEditAdminComponent,
  UtilisateurCreateAdminComponent,
  UtilisateurListAdminComponent,
  UtilisateurViewAdminComponent,
  UtilisateurEditAdminComponent,
  TypeContenuCreateAdminComponent,
  TypeContenuListAdminComponent,
  TypeContenuViewAdminComponent,
  TypeContenuEditAdminComponent,
  CategoryEmailCreateAdminComponent,
  CategoryEmailListAdminComponent,
  CategoryEmailViewAdminComponent,
  CategoryEmailEditAdminComponent,
  ContactCreateAdminComponent,
  ContactListAdminComponent,
  ContactViewAdminComponent,
  ContactEditAdminComponent,
  EtatEmailCreateAdminComponent,
  EtatEmailListAdminComponent,
  EtatEmailViewAdminComponent,
  EtatEmailEditAdminComponent,
  ],
})
export class CommunAdminModule { }
