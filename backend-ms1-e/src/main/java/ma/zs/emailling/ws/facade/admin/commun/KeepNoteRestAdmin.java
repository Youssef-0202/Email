package  ma.zs.emailling.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.emailling.bean.core.commun.KeepNote;
import ma.zs.emailling.dao.criteria.core.commun.KeepNoteCriteria;
import ma.zs.emailling.service.facade.admin.commun.KeepNoteAdminService;
import ma.zs.emailling.ws.converter.commun.KeepNoteConverter;
import ma.zs.emailling.ws.dto.commun.KeepNoteDto;
import ma.zs.emailling.zynerator.controller.AbstractController;
import ma.zs.emailling.zynerator.dto.AuditEntityDto;
import ma.zs.emailling.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.emailling.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.emailling.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/keepNote/")
public class KeepNoteRestAdmin  extends AbstractController<KeepNote, KeepNoteDto, KeepNoteCriteria, KeepNoteAdminService, KeepNoteConverter> {


    @Operation(summary = "upload one keepNote")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple keepNotes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all keepNotes")
    @GetMapping("")
    public ResponseEntity<List<KeepNoteDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  keepNote")
    @PostMapping("")
    public KeepNote save(@RequestBody KeepNote keepNote) throws Exception {
        return keepNoteAdminService.save(keepNote) ;
    }

    @Operation(summary = "Updates the specified  keepNote")
    @PutMapping("")
    public ResponseEntity<KeepNoteDto> update(@RequestBody KeepNoteDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of keepNote")
    @PostMapping("multiple")
    public ResponseEntity<List<KeepNoteDto>> delete(@RequestBody List<KeepNoteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified keepNote")
    @DeleteMapping("")
    public ResponseEntity<KeepNoteDto> delete(@RequestBody KeepNoteDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified keepNote")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple keepNotes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by personne id")
    @GetMapping("personne/id/{id}")
    public List<KeepNoteDto> findByPersonneId(@PathVariable Long id){
        return findDtos(service.findByPersonneId(id));
    }
    @Operation(summary = "delete by personne id")
    @DeleteMapping("personne/id/{id}")
    public int deleteByPersonneId(@PathVariable Long id){
        return service.deleteByPersonneId(id);
    }

    @Operation(summary = "Finds a keepNote and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<KeepNoteDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds keepNotes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<KeepNoteDto>> findByCriteria(@RequestBody KeepNoteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated keepNotes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody KeepNoteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports keepNotes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody KeepNoteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets keepNote data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody KeepNoteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public KeepNoteRestAdmin (KeepNoteAdminService service, KeepNoteConverter converter) {
        super(service, converter);
    }

    //////

    @PostMapping("keepNote")
    public KeepNote keepNote(@RequestBody KeepNote note) {
        return service.keepNote(note);
    }
    @GetMapping("email/{email}")
    public List<KeepNote> findNotesByPersonneEmail(@PathVariable String email) {
        return service.findNotesByPersonneEmail(email);
    }

    @Autowired

    private KeepNoteAdminService keepNoteAdminService;

    ////////////



}
