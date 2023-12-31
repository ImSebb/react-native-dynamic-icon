
Pod::Spec.new do |s|
  s.name         = "RNDynamicAppIcon"
  s.version      = "1.0.0"
  s.summary      = "RNDynamicAppIcon"
  s.description  = <<-DESC
                  RNDynamicAppIcon
                   DESC
  s.homepage     = ""
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "seb.attwater@gmail.com" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/ImSebb/react-native-dynamic-icon.git", :tag => "main" }
  s.source_files  = "RNDynamicAppIcon/**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  #s.dependency "others"

end

